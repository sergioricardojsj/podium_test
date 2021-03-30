---


---

<h1 id="discourse-automation">Podium Test</h1>
<p>The test project was written for a Podium Test, here are the instructions to run it:</p>

<h3>Prerequisites:</h3>
<ul>
    <li>Docker</li>
</ul>

<h3>Running the project</h3>
<ol>
    <li>
        Go to the project root and type:
        <pre><code>docker build -t project_name .</code></pre>
        hit Enter and wait the download the dependencies for the project.
    </li>
    <br>
    <li>
        After finished the download type:
        <pre><code>docker run -it project_name</code></pre>
        and one more time, hit enter. After doing it, you'll be inside the container
    </li>
    <br>
    <li>
        Make sure you are inside the container and type:
        <pre><code>mvn clean test -DsuiteXmlFile=Suite.xml</code></pre>
        and hit enter.
    </li>
</ol>

The tests will run as expected! :)