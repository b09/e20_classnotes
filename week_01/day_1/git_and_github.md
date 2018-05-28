# Version Control: Git & Github
	
**Lesson Duration: 60 minutes**
	
### Learning Objectives
	
* Understand the purpose of source code control
* Be able to use Git for source code control
  - Stage and commit changes
  - Inspect history and view previous versions of code
* Be able to integrate local repositories with remote repositories on GitHub 
	
## In Real Life Code Changes Often And You End Up With A Lot Of Versions

### A short exercise in frustration: Imagine writing an essay collaboratively by email (15 mins)

a.k.a. How managing your code looked before source control and before Git?

Imagine we're writing an essay together, remotely. We there are a few tools that we could use: Emails, Chat, Dropbox, GoogleDocs

Now imagine:
- Jack writes a little bit and email it to everyone (v1) 
- Three different people download that version, make some changes to the first paragraph and email it via Reply All to everyone.
- Oh no! We not have three different versions.

Problems:

- How do we combine all of our work into one version?
- What to do with conflicts, when many people edited the same line of text?

### Possible solutions for maintaining consistency

- only one person edits at a time: when you're done editing, you send back your version and tell others. Then the next person starts editing. (not really efficient or collaborative)
- each person: when you're writing a message you are responsible for taking onboard other people's edits. (and what about changes that people already made, but did not send yet)
- one smart person: someone is in charge and combines everything and makes decisions about conflicts. This is hard to scale, as they
- some simple but powerful way to communicate about versions: Would it not be nice if we somehow we could easily communicate about who edited what, when and in response to which version. Oh, and a way to solve conflicts easily.

## Git Is A Version Control System For Tracking Files

### History of Git: Free like in free speech and like in free beer

In the history of programming all of the above approaches were used. But doesn't the last one sounds most modern?

In 2005 Linus Torvalds created that simple system for version control. He called it "git" for an English slang word for simple/stupid. It was first used by the team behind Linux operating system (which was used by 70-95% of internet servers, and was the foundation of Android).

Git was quickly picked up and became the standard for version control, because it is Open Source (everyone can see how it's written, contribute to making it better and adjust it for their needs) and is Free ("like in free speech and like in free beer").

### Git is a Version Control System for Code

- Git helps us to **tracks changes** in documents, who made them, why, when and based on what older version
- Git is used for managing **source code** a.k.a. the files that computer programs are made of
- Git makes is possible for a large group of programmers to work on the same program **at the same time**. It helps to deal with conflicts in code and with working on one consistent version.
- Since each developer using Git holds a complete copy of the code base and all its history, developers do not need a centralised place to keep their code, and **do not need ot be online** all the time 
- Developers share updates between each other and **merge all the changes** between their individual repositories
- If everyone commits a lot of small changes it enables **rapid and distributed development** with minimum conflicts
	
### Some Jargon: Repository, Commit, Merge

- **Repository** - A collection of files stored in git. i.e. a source code of an application. Can live on a server or on a local machine.
- **Cloning** - Creating a local copy of the Git repository, identical to the remote Git repository on the server.
- **Staging** - Indicating that you changed a file and would like to commit it back to the git repository. 
- **Commit** - Saving a set of staged changes in the git repository. If this repository is online, other developers will be able to pull your changes.
- **Pull** - getting other people's changes from git
- **Push** - putting your own saved changes to git
- **Revert** - rewinding your code back in time to some other commit
- **Merge** - combining two different people's commits into one consistent version
- **Conflict** - a problem when two people edited the same line of code and git doesn't know how merge them. Conflicts need to be solved manually

## Creating Your Own Git Repository - Local Repository

### Creating our first Local Git Repository (with ```git init```)


Let's start by creating a simple local repository. Open your command line terminal and:
	
Create a folder
	
```
  mkdir myfirstgit
```
	
* Move into this folder
	
```
  cd myfirstgit
```
	
* Initialise an empty repository
	
```
  git init
```
	
You will notice that your command line says "master". This is what is known as a "branch" - do not worry about this too much for now we will revisit it later.  All you need to remember is that code committed to this "master" branch should reflect a current stable version of the code.
	
### Typical Git Workflow - Pull, Make Some Changes, Add, Commit, Push
	
Let's make some changes to our repository:

* But first let's just confirm that the version of the repository we have is the most recent one. This will become very important once you start working with servers and collaborating with other developers.

```
  git pull
```
	
* Add a couple of text files to the directory

```
  touch pikachu.txt charmander.txt
```
	
* Now lets see what the current situation is. Running ```git status``` will show us the current status of our repository.
	
Oh look, git is telling us that there are new files and that they are not staged. So lets now do that.
	
* Stage the file (we can also type out the full file name, but the . adds all files)

```
  git add .
```
	
* See the status of the files. When we run ```git status``` we'll see that the files are staged and ready to be committed. Lets do that now.
	
* Commit the changes (```-m``` means that the meaningful message describing the commit will follow)

```
  git commit -m "Initial commit, Adding some empty text files"
```	

* You can see the history of commits any time with ```git log ``` and you can see a very detailed breakdown of what changed since last commit with ```git diff``` (note that to exit ```diff``` you'll need to type a letter ```q```)
	
Ok, so we've just added some empty files to our git and committed them. Now let's make some changes in our files.
	
* Open your text editor and add one sentence to each file. For example add "A yellow electric pokemon" in pikachu.txt, and "Red fire pokemon" in charmander.txt. You can open your text editor with ```atom .```
	
It's always best to call ```git status``` before git add. We don't want to add files that have been changed accidentally do we?

Look, it now shows that there are files that were modified. Okay so how do we stage those changes?
	
* Stage the changes (In Git, we say that we are staging CHANGES to the files, not the files themselves.

```
  git add .
```
	
* Commit the changes

```
  git commit -m "Add basic information about pokemons to text files"
```
	
You can see how easy it is to commit changes to git. As the projects you work on it becomes really important to commit very often (say max every 30 minutes, or every time you finished some small part of functionality). It is also very important to give commits meaningful names, so you know what happened when, in case you need to rewind your work to some point in the past.
	

## GitHub.com Is Where Git Repositories Live - It's Like a Facebook/Dropbox/Library of Code

### What is GitHub - a host of online repositories

GitHub the biggest online platform for hosting Git repositories. It's where people and organisations can store their code, contribute to it.

You all should have GitHub accounts by now. With a few clicks you store your own software projects there, other people can see them and contribute to them.

Indeed we will use GitHub a lot during your course. That's where you'll submit all the code you write, every homework, every personal and group project.

And once you'll work in the industry, you'll realise that it's basically impossible to work on software, especially in a team, without Git code repositories.

Most modern software companies share some of their code on GitHub with global community of programmers. You can have a look at the code behind some parts of Facebook, Instagram or Android. Have a look later on at what is out there.

- [Facebook's GitHub code libraries](https://github.com/facebook)
- [The whole Ruby programming language (that you will learn)](https://github.com/ruby/ruby)

### Why we use online Git repositories like GitHub

It's important to understand that with Git, we have a local copy of code (like we just made) but there is also remote copies of code that we can "pull" down or "push up" to.
	
There are many ways to host remote Git repositories; but one of the most common ways is to use [GitHub](http://github.com).
	
This is a place to store repositories remotely, acting as a "central" copy of the source code where all participating developers can "push" their code.
	
This means that we an pull down a copy of open source code and contribute to it.
		
The great thing about this is that if our laptop blows up, we can pull down a clean working version of our code at any time.

## Distributing Our Code With a Remote Repository on GitHub
	
### Creating a new Remote Git Repository on GitHub
	
If we want to add a remote for our repository, our first step is to log into GitHub, and 

Create a new, empty repository on  [https://github.com/new](https://github.com/new). You could also add repository on github with [command line](https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/), but using GitHub website is easier.

Select other options based on which scenario you're following (below)

**Give your repository a meaningful name**. Optionally give your repositories a description. You will create over a hundred repositories during this course. Remember that they are public, so your future employers might see them.

I'd recommend names like ```cc-w1-d1-learning-git``` or ```cc-w3-d2-homework-snakes-and-ladders``` rather than something meaningless like ```stuff``` or a bit rude, like ```omg-im-so-sleepy-and-lazy-today-lol``` 

The convention is to use dashes - instead of spaces or underscores.

### Route 1 - Upload to GitHub your Local Git Repository you created before (with ```init```)

Which options to choose when creating the GitHub repository? Since you've already initialised your repository locally, DON'T select the option "initialise the repository with a ```README```" and do not select a ```.gitignore``` file. If you accidentally do - no need to panic; just delete and re-create the repository.

We'll explain later what files ```README.md``` and ```.gitignore``` are for.

* First, tell your Local Repository where its remote location will be. 

Here you'll need to copy-paste the **SSH key (NOT HTTPS)** from GitHub page displayed when you created your repository. It will look like this: ```git@github.com:USERNAME/REPOSITORY-NAME.git```
 
```
  git remote add origin git@github.com:USERNAME/REPOSITORY-NAME.git
```

NOTE: ```origin``` is just a name - we could call it anything. Origin is just a convention.

* Push your Local Repository to the Remote Repository.

This will push all the committed code in the local master branch (we'll cover branches later) to the remote called '[origin](http://stackoverflow.com/questions/9529497/what-is-origin-in-git)'

```
  git push -u origin master
```

NOTE: We add the ```-u``` flag, to setup ```origin master``` as defaults , so that next time we can just say ```git push``` and ```git pull```


### Route 2 - Initialise a new repository on GitHub and then ```clone``` it onto your local machine: 

* Open your newly created repository on GitHub.com. There click the **"Clone or Download" button**, and copy the SSH key from the popup field. It will look like this ```git@github.com:USERNAME/REPOSITORY-NAME.git```

```
  clone git@github.com:USERNAME/REPOSITORY-NAME.git
```
	
## Your Git Mantra
	
When we make changes to local files, these alterations are not automatically saved in the Git. We need to stage these changes with ```add``` and then ```commit``` to our local repository. Finally we need to ```push``` them to the remote repo.
	
For example, let's continue with our Pokemon example:

* Add some changes to your text files, you can open them quickly with ``` atom .```

* Stage your changes for commit 	

```
  git add .
```

* Commit with a meaningful message

```
  git commit -m "description of changes you made"
```

* Push your changes to remote repository

```
  git push
```
	
## Further investigation
	
We'll leave you to investigate other Git resources, cheat-sheets, and tutorials. Please find out what the ".gitignore" file does.
	
GitHub does give you a GUI interface you can install, but we're going to work with the command-line interface for the most part, because we may not always have a GUI available to us.
	
* [Git Docs](http://git-scm.com/docs/)
* [Interactive Tutorial](https://try.github.io/)
* [Git Cheat Sheet](http://byte.kde.org/~zrusin/git/git-cheat-sheet-medium.png)
* [Git Guide](http://rogerdudler.github.io/git-guide/)
