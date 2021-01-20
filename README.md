***Instructions to run application***:
1-Open your console/cmd and make sure that you have a JRE installed.
2-Type a command "java -jar path/filename.jar argument 1 and argument 2".
3-Argument 1 refers to the path of the CSV file that we want to read(Used listAnimal.csv-omitted commas in naturalhabit, colour, country column).
We were getting values separated by commas column wise so multiple values in a column were causing ambiguity. 
4-Argument 2 refers to the path of the FindAnimalLog.txt which may be empty initially.
5-After typing a command with its required argument, press enter and the programe will start executing.

***Execution guidelines***:
1-Once application is a running stage, you will see a menu of options. Since there were so many features, 
I assumed its better to make a menu so its user-friendly.

To Search Query                         Press 1
To Validate CSV File                    Press 2
To Print AnimalLog                      Press 3
To Print CSV File                       Press 4
To Instantiate Animal Class             Press 5
To Count Occured Nouns and Average      Press 6
To Exit                                 Press -1
Please Enter Your Choice

2- If you press 1, the system will ask to enter the query and based on query the results will be displayed.
Ex: based on noun, type, scientific noun and so on.
3- If you press 2, the system will validate the provided CSV file and may throw an exception if any error found.
4- If you press 3, the system will print out the FindAnimalLog.txt file.
5- If you press 4, the system will print out the provided CSV file.
6- If you press 5, the system will initialize the Animal objects dynamically based on the description in the file and will display all objects.
7- If you press 6, the system will display the noun, the number of times it has occured and also the average of each noun as well.
8- If you press -1, the system wil be terminated.
9- If you insert any other option than the above options, then the sytem will display invalid choice.
10- In reference to the feature that is for animals that can walk, swim, fly: query
would be like "animals that can walk".



***Features of wildanimalidentifier that have been implemented***:
1-The software is loading and reading the
file(CSV file).

2-The software saves the queries of the user in a
file named FindAnAnimalLog.txt.

3-The software saves the set of results of the
user in a file named FindAnAnimalLog.txt.

4-The software can create dynamically an
instance of each animal present in the
file using all the description of the animal.

5-The user is able to search an animal by its
noun and the software will display all the
information available on this animal.

6-The user is able to search an animal with a
part of the noun and the software will display
the set of animals found, or if only one animal
is found all the information available for this
animal; e.g. query = owl will find the Little
owl, the Barn owl, the Stygian owl.

7-The user is able to search for an animal using
all the natural habitat(s) of the animal and the
software should display the set of animals
found, or if only one animal is found all the
information available for this animal.

8-The user is able to search for an animal using
the exact size of the animal and the
software should display the set of animals
found, or if only one animal is found all the
information available for this animal.

9-The user is able to search for an animal using
the region or the country of the spotting and
the software should display the set of animals
found, or if only one animal is found all the
information available for this animal.

10-The user is able to search for an animal using
the colour(s) of the animal and the software
should display the set of animals found, or if
only one animal is found all the information
available for this animal.

11-The user is able to search for a bird that have a
specific shape of beak and live in a specific
country and the software should display the
set of birds found, or if only one bird is found
all the information available for this animal.

12-The user is able to search for a bird that has a
specific shape of beak and a specific
wingspan and live in a specific country and
the software should display the set of birds
found, or if only one bird is found all the
information available for this animal.

13-The user is able to search for a bird that has a
specific feathers colour(s) and a specific
beak’s shape and the software should display
the set of birds found, or if only one bird is
found all the information available for this
animal.

14-The software should be able to read the
FindAnAnimalLog.txt.

15-The software should display the number of
times a result was find with the same noun of
animal, and the average of this on the total of
set of results.

16-It is not possible to instantiate an instance of a
type of animal that its size is smaller than the
smallest and larger than the largest animal of
this type.

17-The software cannot create an animal that has
the same noun and scientific noun.

18-The user is able to search for all the animal
that can swim, and the software should display
the set of animals found, or if only one animal
is found all the information available for this
animal.

19-The user is able to search for all the animal
that can walk, and the software should display
the set of animals found, or if only one animal
is found all the information available for this
animal.

20-The user is able to search for all the animal
that can fly, and the software should display
the set of animals found, or if only one animal
is found all the information available for this
animal.


