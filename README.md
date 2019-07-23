This is  a restful web service to track word count in a sentence. 

Built this service based on singleton design pattern using SpringBoot.
                                                                 
This web service have 3 operations. 

First operation takes an input string and counts the words in the input of how many times has each one repeated. 
The second operation returns the statistics i.e. count of each word so far. 
Third operation is reset. It resets all statistics / wipe out all stats
The word count is maintained across all calls and keep adding up with every call operation based on if the word present in the input

Example:

Operation1: With input - 'I have a cat' =>  the service returns  
I -- 1 , have -- 1 , a -- 1 , cat -- 1 

Subsequent Call 
Operation2: With input - 'I have a cat again' => the service returns  
I -- 2 , have -- 2 , a -- 2, cat -- 2, again -- 1

Operation3: Click reset button
Returns nothing. Resets all counters

Operation4: With input - 'I have a dog' =>  the service returns  
I -- 1 ,  have -- 1 , a -- 1 , dog -- 1 



