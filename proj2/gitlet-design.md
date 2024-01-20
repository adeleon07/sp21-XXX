# Gitlet Design Document

**Andre**:

## Classes and Data Structures

### Main
This is the entry point into our program. It takes in arguments from the command line and based on the command (the first element of the args array) calls the corresponding commmand in gitlet which will actully execute the logic of the command. 

#### Fields

1. This class has no fields and hence no associated state: it simply validates arguements and defers the execution to the 
2. Field 2


### Repository
This class is where the main logic of the program will live and handle all the actual commands by reading/writing from/to the correct file, setting up persistenence, and additional error checking.

This class is also responsible for setting u all persistence within Gitlet. 

Logic for all the commands (besides init?) will be deferred to the specific command named classes. the Logic for the commit command will be deferred to the Commit class. 
#### Fields

1. public static final File CWD = new File(System.getProperty("user.dir")); 
   1. The Current Working Directory. Currently default with the public modifier, meaning any thing can use can use the variable _I may decide to change this to private, or package-private e.g. no modifier. Depends on if if want other developers to use this variable?_
2. public static final File GITLET_DIR = join(CWD, ".gitlet");
   1. The hidden .gitlet directory. This is where a copy of old files and other metadata are stored. *It is default set to public, but I will see if I want to change that* 

These fields are both static since we don't instantiate a repository object, but rather use it to house functions.
## Algorithms

## Persistence
The Repository class wihh set up all persistence. It will:
1. Create the .gitlet folder if it doesn't already exist


## Braimstorm
// blob object?

## First Checkpoint
1. init
2. add
3. commit 
4. checkout -- [file name]
5. checkout [commit id] -- [file name]
6. log