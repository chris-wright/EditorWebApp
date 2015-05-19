# EditorWebApp
App to load in FM World data from a spreadsheet, and then action it through Robot classes into the Editor

A bit of a mish-mash of stuff in this project, over a few parts.

Main App - This takes in an input file - or reads similar from a spreadsheet - and turns it into a series of Java objects.  These objects are then iterated over one-by-one with an action file instructing a Java robot on where on screen to click.  This means you can automate any amount of tedious, long-winded edits and get them done quicker than you could do with doing the actions yourself
DB - Tried to get going with MongoDB to experience it, but 1) it didn't work and 2) I'm not sure it was entirely what we wanted to use.  Then tried to create an Oracle database, which worked out to a point.  The idea is to get all the data you've read in from the spreadsheet and allow you to change details in the front end and run these in.  The long term objective would be to be able to edit in a full-run, make some changes on the app front-end, and then have the robot make those changes in isolation.  
Front-end - the aforementioned front-end.  This was a late addition - initially we just had a command-line solution, which worked fine as to do the actual robot work we need to actively  have no front-end (we need the full screen) but isn't very flexible.  The front-end was added so we could monitor the incoming data in a different way, and allow us to extend functionality later.  At the moment we're pretty limited to just inputting all the data into Excel.
