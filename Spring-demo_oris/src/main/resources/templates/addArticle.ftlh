<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавления книги</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"
    >
    </script>
</head>
<body>
<script>
    let refecth = () => {
        console.log("refecth")
        $.ajax({
            type: "GET",
            url: "/addArticle",
            success: function (response) {
                renderTable(response, $('#table'))
            },
            dataType: "json",
            contentType: "application/json"
        })
    }

    function renderTable(article, table) {
        console.log("renderTable")
        let innerHtml = '<tr>\n' +
            '               <th>ID</th>' +
            '               <th>Name</th>' +
            '               <th>Type</th>' +
            '               <th>Text</th>' +
            '            </tr>';
        for (let i = 0; i < article.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + article[i]['id'] + '</td>';
            innerHtml += '  <td>' + article[i]['name'] + '</td>';
            innerHtml += '  <td>' + article[i]['type'] + '</td>';
            innerHtml += '  <td>' + article[i]['text'] + '</td>';
            innerHtml += '</tr>';
        }
        table.html(innerHtml);
    }

    function sendBook(name, type, text) {
        console.log("postik")
        let data = {
            "name": name,
            "type": type,
            "text": text,
        };

        $.ajax({
            type: "POST",
            url: "/addArticle",
            data: JSON.stringify(data),
            success: refecth,
            dataType: "json",
            contentType: "application/json"
        });
    }
    function likeArticle(articleId){
        let dataLike = {
            'bookId': articleId
        }
        $.ajax({
            type: "POST",
            url: "/bookLike",
            data: JSON.stringify(dataLike),
            dataType: "json",
            contentType: "application/json"
        })
    }
</script>
<div class="container">
    <h1>Добавление</h1>
    <label for="title">Название</label>
    <input type="text" id="name">
    <br>
    <label for="description">Тип</label>
    <input type="text" id="type">
    <br>
    <label for="description">Текст</label>
    <input type="text" id="text">
    <br>
    <button class="button" onclick="sendBook(
                                $('#name').val(),
                                $('#type').val(),
                                $('#text').val())">Добавить</button>
</div>
<div>
    <table id="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Text</th>
        </tr>
        <#list articles as article>
            <tr>
                <th>${article.id}</th>
                <th>${article.authorName}</th>
                <th>${article.text}</th>
                <th>${article.likesCount}</th>
                    <button class="button" value="${article.id}" onclick="likeArticle(${article.id})">Лайк</button>
                </th>
            </tr>
        </#list>
    </table>

</div>

</body>
</html>