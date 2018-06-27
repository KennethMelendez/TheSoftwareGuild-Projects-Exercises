
$(document).ready(function () {
  $("#mainInfoDiv").show();
});

/*=================================================================

Created an algorithm that automaticly toggles
and displays content on the page
  FOR MAIN DISPLAY
Directions:
    Align the content array with the button array. 
       content and button should correspond
        with the same index in order to work.

=================================================================*/


//ARRAY OF CONTENT
let hiddenContent = [
  "#mainInfoDiv",
  "#akronInfoDiv",
  "#minneapolisInfoDiv",
  "#louisvilleInfoDiv",
];
//ARRAY OF BUTTONS
let buttons = [
  "#mainButton",
  "#akronButton",
  "#minneapolisButton",
  "#louisvilleButton",
];

//ARRAY OF PARAGRAPH CONTENT
let paragraphContent = [
  "#minneapolisWeather",
  "#louisvilleWeather",
  "#akronWeather"
];

//ARRAY OF PARAGRAPHBUTTONS
let paragraphButtons = [
  "#minneapolisWeatherButton",
  "#louisvilleWeatherButton",
  "#akronWeatherButton"
];




hideContent();
hideContent();
buttonClick();
hoverTable();
activateParagraphButtons();



function activateParagraphButtons() {
  for (let content = 0; content < paragraphButtons.length; content++) {
    let currentButton = paragraphButtons[content];
    let currentContent = paragraphContent[content];
    togglesParagraphButtons(currentButton, currentContent);
  }
}



function hideContent() {
  for (let x = 0; x < hiddenContent.length; x++) {
    $(hiddenContent[x]).hide();
    console.log(hiddenContent[x]);
  }
}

function togglesParagraphButtons(userButton, userContent) {
  $(userContent).hide();
  $(userButton).on("click", function () {
    $(userContent).toggle();
  })
}



function buttonClick() {

  for (let showContent = 0; showContent < hiddenContent.length; showContent++) {
    for (let hideContent = 0; hideContent < hiddenContent.length; hideContent++) {
      $(buttons[showContent]).on("click", function () {


        $(hiddenContent[hideContent]).hide();
        $(hiddenContent[showContent]).show();


      });
    }
  }
}

function hoverTable() {

  $("td").hover(function () {
    $(this).css("background-color", "WhiteSmoke");
  }, function () {
    $(this).css("background-color", "white");
  });

}




