<html>
    <head>
        <title>Index page</title>
    </head>
    <body>
        <h1><i>Welcome to the Page</i></h1>
        <form action="add_new_alien" method="post">
            Enter your alien id:
            <input type="text" name="alien_id"/>
            <br>
            Enter your alien name:
            <input type="text" name="alien_name"/>
            <br>
            <input type="submit">
        </form>

        <hr>

        <h1><i>Find a particular Alien from the Database by ID</i></h1>
        <form action="getParticularAlien">
            Enter your alien id:
            <input type="text" name="alien_id"/>
            <br>
            <input type="submit">
        </form>

        <hr>

        <h1><i>Add new Alien to the Database</i></h1>
        <form action="addAlien" method="post">
            Enter your alien id:
            <input type="text" name="alien_id"/>
            <br>
            Enter your alien name:
            <input type="text" name="alien_name"/>
            <br>
            <input type="submit">
        </form>

        <hr>

        <h1><i>Find a particular Alien from the Database by name</i></h1>
        <form action="getParticularAlienByName">
            Enter your alien name:
            <input type="text" name="alien_name"/>
            <br>
            <input type="submit">
        </form>

    </body>
</html>