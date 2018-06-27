
/*================================================================

*** Required Changes ***

1.Center all H1 elements

2.Center all H2 elements

3.Replace the class that is on the element containing the text “Team Up!” with the class page-header

4.Change the text of “The Squad” to “Yellow Team”

5.Change the background color for each team list to match the name of the team

6.Add Joseph Banks and Simon Jones to the Yellow Team list

7.Hide the element containing the text “Hide Me!!!”

8.Remove the element containing the text “Bogus Contact Info” from the footer

9.Add a paragraph element containing your name and email to the footer. The text must be in Courier font and be 24 pixels in height

================================================================*/
//CENTERING TEXT
css("h1", "text-align", "center");
css("h2", "text-align", "center");
//TEAM COLORS
css(".orange","background-color","#f7b733");
css(".blue","background-color","#6A82FB");
css(".red","background-color","#fc4a1a");
css(".yellow","background-color","#fffc00");
//HIDING ELEMENT
hideCss("#oops");
//CHANGING CLASSNAME
chngClass(".myBannerHeading","page-header");
//ADDING/CHANGING TEXT YELLOW TEAM
chngText("#yellowHeading","Yellow Team");
//ADDING PLAYERS TO YELLOW TEAM
appendTo("<li>Joseph Banks</li> ","#yellowTeamList");
appendTo("<li>Simon Jones</li>","#yellowTeamList");
//REMOVING PLACEHOLDER
remove("#footerPlaceholder");
//ADDING TO FOOTER
appendTo("<p>Kenneth Melendez kmlndz221@gmail.com</p>","#footer");
//positioning footer text/editing
css("#footer","display","flex");
css("#footer","align-items","center");
css("#footer","justify-content","center");
css("#footer","font-family","Courier font");
css("#footer","height","24px");
/*================================================================
created functions that lets me manipulate the dom using JQuery
================================================================*/

function css(selector, propery, value) {
    //$(document).ready(function () {
    $(selector).css(propery, value);
    //});
}

function hideCss(selector) {
    //$(document).ready(function () {
    $(selector).hide();
    // });
}

function chngClass(class1,class2) {
    $(class1).toggleClass(class2);
}


function chngText(selector,inputText){
    $(selector).text(inputText);
}

function appendTo(content1,content2){
    $(content1).appendTo(content2);
}

function remove(remove){
    $(remove).remove();
}

/*================================================================
                end line
================================================================*/









