@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    content = @`
    <table>
        @for(var article : page.getList())
            <tr>
                <td><a href="${NamedRoutes.postPath(article.getId())}">${article.getName()}</a></td>
            </tr>
        @endfor
    </table>
    <a href="?page=${page.getPage() + 1}">Next</a>
    <a href="${NamedRoutes.postsPath()}?page=${page.getPage()}">${page.getPage()}</a>
    @if(page.getPage() != 1)
        <a href="?page=${page.getPage() - 1}">Prev</a>
    @endif
`
)
