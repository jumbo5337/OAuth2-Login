
 $.get("/user", function(data) {
             $("#user").html(data.userAuthentication.details.name);
             $(".unauthenticated").hide()
             $(".authenticated").show()
           });

function showFeed(){
    $.ajax({
            url: '/posts',
            type: 'GET'
        }).done(function(feed) {
           const openHtmlTable = `<table id= "posts-table" style="width:100%">
                                          <tr>
                                              <th>ID</th>
                                              <th>Message</th>
                                              <th>Created Time</th>
                                           <tr>`;
            $('#post-data').append($(openHtmlTable));
            feed.forEach(function(post) {
                const html = `<tr>
                                  <td>${post.id}</td>
                                  <td>${post.message}</td>
                                  <td>${post.created_time}</td>
                              </tr>`;
            $('#posts-table').append($(html));
            });
            $('#post-data').append($(`</table>`));
        }).fail(function() {
            console.log('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa');
        });
     }








