# User Guide

## Features 

### Add Todo 
Adds a Todo Type Task into the Task List

### Add Deadline 
Adds a Deadline Type Task into the Task List

### Add Event 
Adds an Event Type Task into the Task List

### Mark as Done 
Marks the desired task as done.

### Delete Task 
Delete the desired task from the Task List.

### Find Task 
Finds the desired task in the Task List.

### Print Task 
Finds the tasks in the Task List that have the same date.

### List Task 
Prints the Task List.

## Usage

### `list` - prints out the current Task List

Prints out all the entries of the Task List into the command window.

Example of usage: 

`list`

Expected outcome:

` 1.[T][X] a`

### `todo` - Adds a Todo Type Task into the Task List

Adds a Todo Type Task into the Task List

Example of usage: 

`todo (task name)`

Expected outcome:

` Got it. I've added this task:`

`[T][X] a`

`Now you have 7 tasks in the list.`

### `deadline` - Adds a Deadline Type Task into the Task List

Adds a Deadline Type Task into the Task List

Example of usage: 

`deadline (task name /by task by)`

Expected outcome:

` Got it. I've added this task:`

`[D][X] a (by 2010-10-10)`

`Now you have 7 tasks in the list.`

### `event` - Adds an Event Type Task into the Task List

Adds an Event Type Task into the Task List

Example of usage: 

`event (task name /@ task at)`

Expected outcome:

` Got it. I've added this task:`

`[E][X] a (@ 2010-10-10)`

`Now you have 7 tasks in the list.`

### `done` - Marks a specific Task as Done

Marks the desired task as done.

Example of usage: 

`done (task number)`

Expected outcome:

` Nice! I've marked this task as done:`

`[D][V] a (@ 2010-10-10) `

### `delete` - Deletes a specific Task from the Task List

Deletes the desired Task from the Task List.

Example of usage: 

`delete (task number)`

Expected outcome:

`  Noted. I've removed this task:`

`[E][X] b (@ 2010-10-10)`

`Now you have 6 tasks in the list.`

### `find` - Searches a specific Task in the Task List

Searches a specific Task in the Task List by inputting the keyword.

Example of usage: 

`find (a)`

Expected outcome:

` Here are the matching tasks in your list:`

` 1.[E][X] dsa (@ 2009-09-09)`

` 2.[T][X] a`

### `print` - Searches all the Task in the Task List with same date

Searches all the Task in the Task List with same date as the desired date

Example of usage: 

`print (2009-09-09)`

Expected outcome:

` Here are the matching dates in your list:`

` 1.[E][X] dsa (@ 2009-09-09) Sep 9 2009`

### `bye` - Exits the program

Exits the program.

Example of usage: 

`bye`

Expected outcome:

` Bye. Hope to see you again soon!`
