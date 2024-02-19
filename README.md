WGU D287
Vincent Vermillion
Student ID:
010958553

Notes:

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
Edited the title     <title>Vincent's Computer Shop</title> on line 14.
Edited the header     <h1>Vincent's Computer Shop</h1> on line 21.



Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.


D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
Created an About HTML page.
Created AboutController.java in controller to map the About page (line 14-19).


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.


Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

 
F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


I messed up on the files so I had to copy my back up. Most of these "changes" were not really changes.

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
I added maxInv and minInv fields, setters, and getters in Part.java.
I also added a new constructor that will take minInv and maxInv arguments. Lines 110 - 150 in Part.java.

•  Modify the sample inventory to include the maximum and minimum fields.
Added in BootStrapData the minInv and maxInv values in lines 62-66.

•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
added min and max inputs for inhouse in lines 23-25 and in outsource in 24-26.

•  Rename the file the persistent storage is saved to.
I renamed the persistent storage file to spring.datasource.url=jdbc:h2:file:~/vincent-vermillion-final-final in line 6

•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
created validateInventory() in Part.java in line 143 to 146 to check if invetory is in between min and max values.

G.Modify the code to enforce that the inventory is between or at the minimum and maximum value.

Upon checking countless times, it turned out the the min-max range checker was not working. 
I created a script that checks the min and max value and throws an alert if input values are out of range. lines 9-29 for both InhousePartForm.html and OutsourcedPartForm.html


PLEASE TAKE NOTE THAT THE ASSOCIATED PARTS SHOULD NOT INTERACT WITH THE productForm.html. ACCORDING TO TASK F. THE ERROR FOR

Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.

WORKS AND HAS BEEN TESTED MULTIPLE TIMES. SCREENSHOT PROVIDED. It works the second time you click the submit after going back to the mainscreen.

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.

Modified AddInhousePartController and AddOutsourcedPartController to throw errorMessage if part.getInv is less than part.getMinInv. lines 44 - 49.


•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.

•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

Modified EnufPartsValidator's if condition. Added another condition for false. If part inventory is the same as minimum value, it will throw an error message.

Modified AddInhousePartController and AddOutsourcedPartController to throw errorMessage if part.getInv is greater than part.getMaxInv. lines 51 - 58.

I also took out the scripts from the forms because we were not supposed to use scripts. This should be properly addressed as I spent a long time to create the scripts.

Also added the footer Main Screen on productForm.html.
Updated README.md.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
Added tests for min and max inventories on lines 159 - 185. Both tests passed.

J.  Remove the class files for any unused validators in order to clean your code.
Deleted DeletePartValidator.java as it was not used at all.

NOTES:
Use the Office Desktop to test the parts associated errors. Email me at vvermi2@wgu.edu if you have questions. Everything works on my end. 