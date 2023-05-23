# Text-Adventure-Game-Using-LLM-API
The LLM Generates An Initial Story Premise With 3 Options, The User Selects One Of The 3 Choices Given, Where Users Can Make Choices That Affect The Outcome Of The Story, The Users Choice Is Sent Back As A Prompt, And This Creates A Dynamic Real-time Story Environment 

## Steps To Create App 

- Create a new Android Studio project with a blank activity.
- Add necessary dependencies for making API calls and parsing JSON data.
- Create a layout for the app with a TextView to display the story and three buttons for the user's choices.
- Make an API call to the LLM backend to generate the initial story premise with three options.
- Parse the JSON data received from the API call and display the story and options in the TextView and buttons respectively.
- Set onClickListeners for each button to handle the user's choice.
- When a button is clicked, send the user's choice back to the LLM backend as a prompt.
- Receive the updated story premise from the backend and repeat steps 5-7 until the story ends.
