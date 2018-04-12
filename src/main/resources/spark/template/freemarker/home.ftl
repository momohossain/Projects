<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <meta name="description" content="CSH Project">
    <meta name="author" content="Momo Hossain">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/styles/main.css">
</head>
<body>
<div class="header" style="background-color:#b0197e">
    <a href="/">
        <img src="https://www.csh.rit.edu/~mbillow/Images/csh-logo-discourse-round.svg" alt="CSH Projects Home" id="site-logo" hspace="10" vspace="10" style="padding-left: 15px">
    </a>
</div>
<table class="home-div-table">
    <tr>
        <th><b>Antique Projects</b></th>
    </tr>
    <tr class="add_idea_row">
        <td align="center">
            <a href="/add/AntiqueProject">
                <button class="add_idea"><span style="color: #ff23b2">+</span>Add Idea</button>
            </a>
        </td>
    </tr>
    <#list pastIdeas as idea>
        <tr>
<#--
            <#list pastSet as idea>
-->
            <td>
                <p>${idea.getTitle()} : ${idea.getName()}</p>
            </td>
<#--
            </#list>
-->
        </tr>
    </#list>
    <#--<tr>
        <td>
            <p>
                This is a sample idea!
            </p>
        </td>
    </tr>-->
</table>
<table class="home-div-table">
    <tr>
        <th><b>Present Dabbling</b></th>
    </tr>
    <tr class="add_idea_row">
        <td align="center">
            <a href="/add/PresentDabble">
                <button class="add_idea"><span style="color: #ff23b2">+</span>Add Idea</button>
            </a>
        </td>
    </tr>
    <#list pastIdeas as idea>
        <tr>
        <#--
                    <#list pastSet as idea>
        -->
            <td>
                <p>${idea.getTitle()} : ${idea.getName()}</p>
            </td>
        <#--
                    </#list>
        -->
        </tr>
    </#list>
</table>
<table class="home-div-table">
    <tr>
        <th><b>Envision Projects</b></th>
    </tr>
    <tr class="add_idea_row">
        <td align="center">
            <a href="/add/EnvisionProject">
                <button class="add_idea"><span style="color: #ff23b2">+</span>Add Idea</button>
            </a>
        </td>
    </tr>
    <#list pastIdeas as idea>
        <tr>
        <#--
                    <#list pastSet as idea>
        -->
            <td>
                <p>${idea.getTitle()} : ${idea.getName()}</p>
            </td>
        <#--
                    </#list>
        -->
        </tr>
    </#list>
</table>
</body>
</html>