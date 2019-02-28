# MiniCAD in Java

This app can simulate the use of a CAD in Java using a text file in which you can define different 2D geometric forms.
- first line of the input file needs to be the amount of forms in the drawing (including the canvas)
- next lines are the forms that you want to draw keeping in mind that if they overlap the last form written will be on top

Types of forms:
- CANVAS *height* *width* #*color* *opacity*
- LINE *xPoint1* *yPoint1* *xPoint2* *yPoint2* #*color* *opacity*
- SQUARE *xTopRightCorner* *yTopRightCorner* *sideOfSquare* #*borderColor* *borderOpacity* #*color* *opacity*
- DIAMOND *xCenter* *yCenter* *sideOfDiamond* #*borderColor* *borderOpacity* #*color* *opacity*
- TRIANGLE *xPoint1* *yPoint1* *xPoint2* *yPoint2* *xPoint3* *yPoint3* #*borderColor* *borderOpacity* #*color* *opacity*
- CIRCLE *xCenter* *yCenter* *radius* #*borderColor* *borderOpacity* #*color* *opacity*
- POLYGON *N* *xPoint1* *yPoint1* *xPoint2* *yPoint2* ... *xPointN* *yPointN* #*borderColor* *borderOpacity* #*color* *opacity*

In input/ there are several examples on how to format the input text file.
