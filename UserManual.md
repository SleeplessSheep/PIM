# PIR (Personal Information Record) User Manual

## Type of PIR (Personal Information Record)

1. TextNote: A record type that contains note content.
   
   - Note content: Text

2. Task: A record type that contains a description and a deadline.
   
   - Description: Text
   - Deadline: Date (Format: yyyy-MM-dd HH:mm, e.g., 2023-11-12 14:25)

3. Event: A record type that contains a description, starting time, and alarm.
   
   - Description: Text
   - Starting time: Date (Format: yyyy-MM-dd HH:mm, e.g., 2023-11-12 14:25)
   - Alarm: Date (Format: yyyy-MM-dd HH:mm, e.g., 2023-11-12 14:25)

4. Contact: A record type that contains a name, address, and mobile number.
   
   - Name: Text
   - Address: Text
   - Mobile number: Number (Numeric value only, no characters included)

## Command

The commands you can use include: Create, Modify, Delete, Export, Import, Print, Search. You can use these commands when you see the following prompt:

```
Personal Information Manager (PIM)-Menu
Please enter command: [ Create | Modify | Delete | Export | Import | Print | Search ]
```

To use a command, type in the command name. For example: `Create`. Note that the first character should be uppercase, and there should be no space characters in the middle or end of the command.

If you input an invalid command, you will see an error message:

```
Invaild input: a
```

Then you can use command when you see the prompt again, prompt:

```
Personal Information Manager (PIM)-Menu
Please enter command: [ Create | Modify | Delete | Export | Import | Print | Search ]
```

## Create Command

After inputting `Create` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Create module - Enter record type [ Event | Contact | Task | TextNote ]:
```

You can input the record type, choosing from Event, Contact, Task, or TextNote. For example: `TextNote`. Note that the first character should be uppercase, and there should be no space characters in the middle or end of the type.

After inputting the type correctly, the system will ask you to input data. For creating a TextNote, you will see:

```
Enter text content for TextNote:
```

You can type in the content for the TextNote and press Enter when you finish inputting. For example, if you type in "This is text content" and press Enter, you will see the following message:

```
New record created | 1 | TextNote | content: This is text content
```

This message confirms that the record has been successfully created. The unique ID of the record is indicated by the number after the first `|` character (`1` in this example). You can use this ID for Display/Delete/Modify commands. The record type should match the type you selected (`TextNote` in this example). The `content` field shows the data you just entered.

If you input the wrong data that does not match the required data type, the system will show an error message. For example:

```
Create module - Enter record type [ Event | Contact | Task | TextNote ]:
Task
Enter description for Task:
This is Task
Enter deadline for Task (YYYY-MM-DD HH:MM):
wrong input for date
[ 1:This is Task 2:wrong input for date ]
*** occur in mapToCommand ***Unparseable date: "wrong input for date"
```

After receiving this message, you will be sent back to the Personal Information Manager (PIM)-Menu. The record will not be stored, and you can use the next command.

## Display Command

After inputting `Print` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Display module - Please enter [ All ] or the record ID for a specific PIR
```

When you want to print all the records, you can type in `All` (note the capital 'A'). The following is a showcase after creating six records:

```
Display module - Please enter [ All ] or the record ID for a specific PIR
All
There are 6 records.
1 | TextNote| content: This is text content
2 | Event| description: meeting1 | starting time: 2023-11-10 13:30 | alarm: 2023-11-10 13:20
3 | Event| description: meeting with Julia | starting time: 2023-11-11 14:30 | alarm: 2023-11-11 14:20
4 | TextNote| content: Hello World
5 | Contact| name: Dicky | address: PolyU | mobile number: 98561639
6 | Task| description: Buy groceries | deadline: 2023-11-12 18:00
```

This message displays all the records stored in the system. Each record is represented by a line that starts with the record ID followed by the record type and its corresponding data fields.

If you want to display a specific record, you can input its ID. For example, if you type `3`, you will see:

```
Display module - Please enter [ All ] or the record ID for a specific PIR
3
3 | Event| description: meeting with Julia | starting time: 2023-11-11 14:30 | alarm: 2023-11-11 14:20
```

This message displays the record with ID 3.

If you input an invalid ID, the system will show an error message: "No such ID: xxx (the text you just typed)". You can then input the next command after seeing the error message.

## Search Command

After inputting `Search` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Search module - Please enter the criteria you want to use to search for personal information records (PIRs):
[ date | text | type ]
```

You can input `date`, `text`, or `type` as the criteria for your search. For example, if you want to search for records that belong or do not belong to a specific type, you can input `type`.

After inputting `type`, the following will be shown:

```
Please enter the type: [ Event | Contact | Task | TextNote ]
```

If you want to search for records that belong or do not belong to the `Event` type, you can input `Event`.

Next, it will ask you for the NegationIndicator:

```
Is the criteria with NegationIndicator (NOT): [ Y | N ]
```

If you want to search for records that belong to the `Event` type, input `N`. If you want to search for records that do not belong to the `Event` type, input `Y`.

For example, if you want to search for records that do not belong to the `Event` type, you can input `Y`.

The system will show the records that do not belong to the `Event` type:

```
Current result:
There are 3 records.
1 | TextNote | content: This is text content
4 | TextNote | content: Hi World
6 | Task | description: This task | deadline: 2023-11-14 17:20
```

It will then ask you if you want to search with more criteria:

```
Do you want to search with more criteria: [ Y | N ]
```

If you want to perform another search using the current search result, you can input `Y`. Otherwise, you can input `N` to exit the Search module.

For example, if you want to perform another search, you can input `Y`, and then you will be prompted to enter the search criteria:

```
Search module - Please enter the criteria you want to use to search for personal information records (PIRs):
[ date | text | type ]
```

Suppose you want to search for a record that contains "Hi" in its text (content/description/address/name). You can enter `text`, `Hi`, and `N` separately.

```
text
Please enter the text:
Hi
Is the criteria with NegationIndicator (NOT): [ Y | N ]
N
```

Then, the system will prompt you to enter the logic connector:

```
Please enter the logic connector: [ && | || ]
```

If you want to search for a record that satisfies both the first criterion (not belonging to the `Event` type) and the second criterion (contains "Hi"), you can input `&&`. If you want to search for a record that satisfies either the first criterion or the second criterion, you can input `||`. In this example, we will use `&&`.

After connecting the criteria with `&&`, the system will display the search result:

```
There is 1 record.
6 | Task | description: This task | deadline: 2023-11-14 17:20
```

Finally, the system will ask if you want to search with more criteria:

```
Do you want to search with more criteria: [ Y | N ]
```

You can input `N` to exit the Search module.

## Modify Command

After inputting `Modify` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Modify module - Please enter the record ID to modify a specific PIR:
```

You need to input the ID of the record you want to modify. You can use the Print or Search commands to find the ID of the record you wish to modify.

Here's an example of modifying a record:

```
Modify module - Please enter the record ID to modify a specific PIR:
4
Editing: 4 | TextNote | content: Hello World
Enter text content for TextNote:
Hi World
Record modified | 4 | TextNote | content: Hi World
```

After seeing the message "Enter xxx (data) for Xxx (type):", you can input the new data for the corresponding field.

If you enter an ID that does not exist, the following message will be displayed:

```
Modify module - Please enter the record ID to modify a specific PIR:
7
*** Error: No such ID: 7 ***
```

If you enter the wrong data type for a field, you will be sent back to the main menu, and the record will remain unchanged.

## Delete Command

After inputting `Delete` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Delete module - Please enter the record ID for the PIR you want to delete:
```

You can input the ID of the record you want to delete. For example, if you want to delete the record with ID 1, you can type `5`.

If the ID you input is valid, the system will show the record's data . For example, if you want to delete the record with ID 5, you will see:

```
Delete module - Please enter the record ID to delete specific PIR
5
Deleted: 5| Contact| name: Dicky| address: PolyU| mobile number: 98561639
```

This message confirms that the record has been successfully deleted. 

If you input an invalid ID, the system will show an error message: "No such ID: xxx (the text you just typed)". You can then input the next command after seeing the error message.

## Export Command

After inputting `Export` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Export module - Please enter the filename (including extension) to export the data:
```

You can input the filename (including extension) for exporting the data. For example, if you want to export the data to a file named `data.txt`, you can type `data.txt`.

If the filename you input is valid, the system will export the data to the specified file. 

## Import Command

After inputting `Import` in the Personal Information Manager (PIM)-Menu, the following will be displayed:

```
Import Module - Enter the file name of .pim (no .pim included):
Then you can input the file name for .pim file. In this show case, I input "ExportPIM"
Then the record will be created
```

If you input an invalid file name, the system will show an error message:

```Import
Import Module - Enter the file name of .pim (no .pim included):
asd
---ImportCommand---..\PIM\pim\asd.pim (The system cannot find the file specified)
```