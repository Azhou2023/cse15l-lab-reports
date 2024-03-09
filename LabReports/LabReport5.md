# Lab Report 5

## Student Post

Hi, I'm currently working on a java method that reverses an input string and running it through a shell script. This is my method and how I'm running it through main:

```
static void reverseInPlace(String[] arr) {
    for(int i = 0; i < arr.length/2; i += 1) {
        String temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
}

public static void main(String[] args){
    String argument = args[0];
    String[] list = argument.split("");
    reverseInPlace(list);
    System.out.println(String.join("",list));
}
```

I think this code should be fine, but when I run my script in the command line, I don't get an expected answer:

```
$ bash test.sh test
hs.tset
```

Could anyone help me figure out why there's an extra `hs.` in front of the expected output? I think it could be something with how I'm splitting/joining the string in the main method but I'm not sure?

## TA response

Hey there, could you provide the contents of your shell script? It looks like it's reversing the name of your script, `test.sh` instead of the argument. Maybe you're using `$0` instead of `$1` to refer to the first argument? Bash syntax differs from how args are referenced in java in that the arguments are 0-indexed in java but 1-indexed in bash, since 0 is reserved for the file name that comes immediately after the bash keyword.

## Student response

Thank you, that was indeed the problem. This was my shell script:

```
javac *.java
java ArrayExamples $0
```

I've changed it to $1 and now the method returns the expected output:

```
$ bash test.sh test
tset
```

The bug was simply that I misunderstood how to refer to arguments in bash. Thanks so much for the help!

## Setup information

Directory structure: <br>

```
Project
    test.sh
    ArrayExamples.java
```

File contents before bug-fix:

```
public class ArrayExamples {

    static void reverseInPlace(String[] arr) {
      for(int i = 0; i < arr.length/2; i += 1) {
        String temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
      }
    }

    public static void main(String[] args){
      String argument = args[0];
      String[] list = argument.split("");
      reverseInPlace(list);
      System.out.println(String.join("",list));
    }
  }
```

```
javac *.java
java ArrayExamples $0
```

Trigger for bug:
`bash test.sh test`

Bug fix:
Change the `$0` in `test.sh` to `$1` in order to reference the actual first argument instead of the name of the shell script.

# Reflection

I learned a ton of interesting new stuff this quarter; while I was already quite familiar with some of concepts such as git, a lot of the new concepts were super interesting and will definitely be really helpful for me in the future. Bash scripting is a super interesting way to automate certain functions and is something that I've already been using in my own personal projects. Vim is something I've always been a bit intimidated by, but I'm really glad that we went over that it's now something that I can use, even if at a somewhat basic level. Tools like jdb and JUnit have been super useful to learn and I anticipate using them a lot more in the future. Overall, I'm super grateful for the stuff we've done this quarter and I'm excited to apply them in my future CS endeavours.
