# YC Chatbot

This is an interactive chatbot named "YC" that helps you manage your tasks.  
Your tasks will be stored in a Task List with their details and completion status.  
  
There are three types of tasks you may input:  
**to-do**: a task that simply contains a description  
**task with a deadline**: a task with a description and a deadline  
**event**: an event with a description, start time and end time. 

### Points to note
1. Please strictly follow the format as denoted below, else the chatbot will not be able to process your command.
2. Only the below listed commands are available. All other commands will be invalid.

_**Given below are instructions on how to use it.**_

## Listing out the stored list of tasks
Type the command "**list**" and all stored tasks will be displayed.  
  
*Note: completion status is denoted by "X" if completed and empty if not yet completed.  
T, D, E indicates it is a to-do task, a task with a deadline or an event respectively.*

## Adding a To-do task
It allows you to input a task with its description and will be stored in a Task List.  
  
Type the command in the following format:  
**todo** TASK_DESCRIPTION

## Adding a task with a deadline
It allows you to input a task with its description and a deadline. It will be stored in a Task List.  
  
Type the command in the following format:  
**deadline** TASK_DESCRIPTION /by DEADLINE

## Adding an event 
It allows you to input a task with its description and a deadline. It will be stored in a Task List.  

Type the command in the following format:  
**event** TASK_DESCRIPTION /from START_TIME /to END_TIME

## Deleting a task from the list
It allows you to delete a task from the Task List.  

Type the command in the following format:  
**delete** TASK_INDEX

For example, if the list of tasks is the following:  
1[D][ ] ip (by: 3 Oct)  
2[E][X] exam (from: 2pm to: 4pm)
  
And you want to remove the task "ip". You can type "delete 1".

## Finding tasks that contain a keyword
It allows you to list all the tasks related to the keyword.  

Type the command in the following format:  
**find** KEYWORD  
  
For example, if the list of tasks is the following:  
1[D][X] ip (by: 3 Oct)  
2[E][X] exam (from: 2 to: 4)  
3[T][ ] fin exam  
4[T][ ] ec exam  
  
And you typed "find exam".It will display the following.  
  
Here are the matching tasks in your list:  
1.[E][X] exam (from: 2 to: 4)  
2.[T][ ] fin exam  
3.[T][ ] ec exam  

## Marking a task as done
It allows you to mark a task in the Task List as completed.  

Type the command in the following format:  
**mark** TASK_INDEX  
  
Then you will see that the task will be stored with the status "X".  
1[E][X] exam (from: 2 to: 4)

## Marking a task as NOT done
It allows you to mark a task in the Task List as **NOT** completed.  

Type the command in the following format:  
**unmark** TASK_INDEX  
  
Then you will see that the status of the task will be stored as empty.  
1[E][ ] exam (from: 2 to: 4)

## Conclusion
Above are all the commands available and their respective formats. Hope this user guide helps you to know how the chatbot works.  
  
*Enjoy the use of the chatbot!*
