@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;

    @Override
    public void init() {
        commentDAO = new CommentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listComments(request, response);
                break;
            case "add":
                showAddCommentForm(request, response);
                break;
            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addComment(request, response);
    }

    private void listComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentDAO.selectAllComments();
        request.setAttribute("commentList", comments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/commentList.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddCommentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addComment.jsp");
        dispatcher.forward(request, response);
    }

    private void addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String commentText = request.getParameter("commentText");

        Comment comment = new Comment(postId, userId, commentText);
        commentDAO.insertComment(comment);
        response.sendRedirect("comment?action=list");
    }
}
