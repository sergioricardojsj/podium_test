---


---

<h1 id="discourse-automation">Discourse Automation</h1>
<p>The automation was created in version 11 of Java.</p>
<p>Easily installed on linux by typing on terminal</p>
<pre><code>sudo apt-get install default-jdk
</code></pre>
<h1 id="step-by-step">Step by step</h1>
<p>You will have two options to run the project</p>
<ol>
<li>Locally</li>
<li>Selenium Grid</li>
</ol>
<h2 id="locally">1. Locally</h2>
<p>As default the project is configured to run locally, so, basically what you will have to do is go to the <code>Suite.xml</code> and run or you can run the test inside of the class itself.</p>
<h2 id="selenium-grid-remotely">2. Selenium Grid (Remotely)</h2>
<p>It will be necessary that you have docker and docker-compose installed. You can download it easily in the following links for <a href="https://docs.docker.com/docker-for-windows/install/">windows</a>, <a href="https://docs.docker.com/engine/install/ubuntu/">linux</a> and <a href="https://docs.docker.com/docker-for-mac/install/">mac</a>.</p>
<p>Make sure you have both installed and follow the following steps.<br>
Go to the project root and open it on a terminal window and execute the following command: <code>docker-compose up -d</code></p>
<p>It will take a little bit of time in the first execution, but, it downloads the dependencies really fast.</p>
<p>After downloading the dependencies you can make sure it’s okay and running by accessing <code>http://localhost:4444/</code></p>
<p>Now you will have to go to the <code>Suite.xml</code> file and located the tag <code>&lt;parameter name="browser" value="chrome" /&gt;</code> and change it to <code>&lt;parameter name="browser" value="cremote" /&gt;</code></p>
<p>After that, you will be able to run the project remotely.</p>
<p>Note: The test will execute remotely only if executed from the suite.</p>

