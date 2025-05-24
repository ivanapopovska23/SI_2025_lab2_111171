# Ивана Матиева 111171  


# 2. CFG   
   ![image](https://github.com/user-attachments/assets/02c73aa3-b165-42f9-9410-3012ce664fb3)




# 3. Цикломатска комплексност  
   пресметана според:
   1. Број на региони + 1 --> P+1 односно 8 + 1 = 9
   2. Број на ребра - број на јазли + 2 --> C=E-N+2 односно 27 - 20 + 2 = 9


# 4. Every Statement
   
   ![image](https://github.com/user-attachments/assets/08612ae0-efbb-4b9c-aea6-23f209d57746)




Во завршниот јазол водат 5 ребра, односно 4 RT exceptions и еден return.

Првиот тест случај е кога allItems=null, фрла RT exception 1 - allItems list can't be null!.

Во вториот тест случај allItems листата се состои од 3 продукти (соодветно ги имам подредено полињата - name, price, discount, quantity).
Цената на маскарпонето е поголема од 300 (океј и без ова ќе влези, бидејќи има попуст) и ќе влези во node 7, попустот е поголем од нула, па ќе влези во 9.
Од пишкотите има повеќе од 10 артикли, т.ш. пак ќе влези во 7 (иако не е потребно, изминат е овој node со маскарпонето), важното е дека нема попуст и сега наместо во 9, ќе влези во 10.
Е сега, во третиот продукт има празен стринг за име, т.ш. ќе фрли RT exception 2 - Invalid item!.

Во третиот тест случај има картичка со број на цифри помал од 16, т.ш. ќе фрли RT exception 3 - Invalid card number!.

Во четвртиот тест случај има картичка со точен број на цифри, но освен цифри има и букви, т.ш. ќе фрли RT exception 4 - Invalid character in card number!.

Во петтиот тест случај името на продуктот е со должина минимум еден карактер и бројот на картичката е валиден и на крај се враќа сумата.

Од самата табела се гледа дека со **минимум 5 тест случаи** се изминуваат сите јазли и се исполнува критериумот за Every Statement.  


# 5. Multiple Condition

Без разлика какви и да се условите, секојпат кога има OR(ИЛИ) услов со три променливи, ќе бидат **точно 4 тест случаи** :)

Всушност, OR(ИЛИ) условот е точен кога БАРЕМ ЕДЕН од подусловите е точен, т.ш. одиме до прв точен подуслов, останатите се lazy evaluation (нивната вредност не прави никаква промена во крајниот исход).  
И на крај ни останува завршниот случај - кога сме ги изминале сите подуслови и сите тие се неточни.  

**TXX** - првиот од трите подуслови е точен, нема потреба да се проверуваат останатите, целиот услов е точен (пр. price=599, а останатите може да се било како, да речеме discount=0, quantity=1)  
**FTX** - првиот е неточен, се проверува вториот - тој е точен, па нема потреба да се провери третиот, целиот услов е точен (пр. price=89, discount=0.1, третиот може да е било како, да речеме quantity=2)  
**FFT** - првиот е неточен, се проверува вториот - тој е неточен, се проверува третиот - тој е точен, целиот услов е точен (пр. price=300, discount=0, quantity=12)  
**FFF** - првиот е неточен, вториот е неточен, третиот е неточен, па и целиот услов ќе биде неточен (пр. price = 299, discount=0, quantity=1)  

# 6. Unit Tests  

**EveryStatementCriteria**  
Test Case 1: Checking that the checkCart method will throw an exception and that the exception message will contain "allItems list can't be null!"  
Test Case 2: Checking that the checkCart method will throw an exception and that the exception message will contain "Invalid item!"  
Test Case 3: Checking that the checkCart method will throw an exception and that the exception message will contain "Invalid card number!"  
Test Case 4: Checking that the checkCart method will throw an exception and that the exception message will contain "Invalid character in card number!"  
Test Case 5: Checking that the checkCart method will be executed successfully and will return the result 470 (not 500), because the price is larger than 300 (it's 500) it will enter the condition and apply sum-=30, so 500-30=470.  

**MultipleConditionCriteria**  
So for this criteria, there are minimum 4 test cases, I used 4 different items according to the condition (TXX, FTX, FFT, FFF), they all go through different paths, so every calculation will be different based on the condition they enter (or not), and I check that the result is as expected (the sum of all of the items - according to the logics).  
(599-30)+(89*0.9*2-30))+(300*12-30)+299=569+130.2+3570+299=4568.2


