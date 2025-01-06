@WebServlet("/post")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PostDAO postDAO;

    @Override
    public void init() {
        postDAO = new PostDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listPosts(request, response);
                break;
            case "add":
                showAddPostForm(request, response);
                break;
            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    private void listPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = postDAO.selectAllPosts();
        request.setAttribute("postList", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/postList.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddPostForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addPost.jsp");
        dispatcher.forward(request, response);
    }
}
