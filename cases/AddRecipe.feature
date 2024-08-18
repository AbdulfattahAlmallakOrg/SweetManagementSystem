@tag2
Feature:Add recipe from user
 Scenario Outline: user enter valid info to make recipe post
    Given user in add recipe page
    When user enter all field and click post '<cakeName>' and '<imagePath>' and '<Decription>' and '<needs>' and '<allerg>'
    Then the post will create
   Examples:
     | cakeName       | imagePath   | Decription    | needs             | allerg           |
     | blubbary cake 1| Path12      | a sweet cake  | Egg               | wheet            |
     | blubbary cake 4| Path2       | a sweet cake  | Egg,Wheet         | wheet,milk       |
     | blubbary cake 2| Path3       | a sweet cake  | Egg,Wheet,water   | wheet,milk,Egg   |
     | blubbary cake 3| Path4       | a sweet cake  | Egg,Wheet         | wheet            |

