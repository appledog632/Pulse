@WebServlet("/like")
public class LikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LikeDAO likeDAO;

    @Override
    public void init() {
        likeDAO = new LikeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listLikes(request, response);
                break;
            case "add":
                showAddLikeForm(request, response);
                break;
            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addLike(request, response);
    }

    private void listLikes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Like> likes = likeDAO.selectAllLikes();
        request.setAttribute("likeList", likes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/likeList.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddLikeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addLike.jsp");
        dispatcher.forward(request, response);
    }

    private void addLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        Like like = new Like(postId, userId);
        likeDAO.insertLike(like);
        response.sendRedirect("like?action=list");
    }
}
