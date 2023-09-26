package com.education;

import java.util.Stack;

public class SimplifyString {

    //Need to simplify string path
    public static void main(String[] args) {
        String input1 = "/var/./lib/../test";
        String input2 = "/var/lib/../../test";
        String input3 = "/var/lib1/lib2/lib3/././././././lib4/../../../..";

        String output1 = normalize(input1);
        String output2 = normalize(input2);
        String output3 = normalize(input3);

        System.out.println(output1); // expected output: /var/test
        System.out.println(output2); // expected output: /test
        System.out.println(output3); // expected output: /var
    }

    private static String normalize(String input) {
        // Stack to store the file's names.
        Stack<String> st = new Stack<>();

        // temporary String which stores the extracted
        // directory name or commands("." / "..")
        // Eg. "/a/b/../."

        // contains resultant simplifies String.
        StringBuilder res = new StringBuilder();

        // every String starts from root directory.
        res.append("/");

        // stores length of input String.
        int lenA = input.length();

        for (int i = 0; i < lenA; i++)
        {

            // we will clear the temporary String
            // every time to accommodate new directory
            // name or command.
            // dir will contain "a", "b", "..", ".";
            StringBuilder dir = new StringBuilder();

            // skip all the multiple '/' Eg. "/////""
            while (i < lenA && input.charAt(i) == '/')
                i++;

            // stores directory's name("a", "b" etc.)
            // or commands("."/"..") into dir
            while (i < lenA && input.charAt(i) != '/')
            {
                dir.append(input.charAt(i));
                i++;
            }

            // if dir has ".." just pop the topmost
            // element if the Stack is not empty
            // otherwise ignore.
            if (dir.toString().equals(".."))
            {
                if (!st.empty())
                    st.pop();
            }

            // if dir has "." then simply continue
            // with the process.
            else if (dir.toString().equals("."))
                continue;

                // pushes if it encounters directory's
                // name("a", "b").
            else if (dir.length() != 0)
                st.push(dir.toString());
        }

        // a temporary Stack (st1) which will contain
        // the reverse of original Stack(st).
        Stack<String> st1 = new Stack<String>();
        while (!st.empty())
        {

            st1.push(st.pop());
            // st.pop();
        }


        // the st1 will contain the actual res.
        while (!st1.empty())
        {

            // if it's the last element no need
            // to append "/"
            if (st1.size() != 1)
                res.append(st1.pop()).append("/");
            else
                res.append(st1.pop());

            // st1.pop();
        }
        return res.toString();
    }
}


