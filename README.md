# announcements-crud
Technologies
--------------------------
Java (JEE 7 Web profile), JQuery, Bootstrap, RESTful, MongoDB, Maven, GIT, Jboss-as-7.1.1.Final <br/>

Additional extensions used
--------------------------
<ul>
<li>Bootstrap Table to bind Json data to the HTML table in an easy way. http://wenzhixin.net.cn/p/bootstrap-table/docs/examples.html </li>

<li>
Responsive popup window to show the CreateNew Form.  http://dimsemenov.com/plugins/magnific-popup/
</li>

<li>
JQuery Form plugin to post form data easily  http://malsup.com/jquery/form/
</li>
</ul>
Prerequisites before running
--------------------------
Install Mongo DB and have the service running. <br/>
Install JBoss AS 7,

Running the Application
--------------------------

1. mvn clean install <br/>
2. copy the built war file from the target directory to the Jboss - jboss-as-7.1.1.Final\standalone\deployments folder <br/>
3. in jboss-as-7.1.1.Final\bin run standalone.bat.<br/>
4. Page can be accessed from <a href='http://localhost:8080/announcement/'>http://localhost:8080/announcement/</a>




