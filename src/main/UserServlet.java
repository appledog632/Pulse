@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listUsers(request, response);
                    break;
                case "add":
                    showAddUserForm(request, response);
                    break;
                default:
                    response.sendRedirect("index.html");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.selectAllUsers();
        request.setAttribute("userList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userList.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addUser.jsp");
        dispatcher.forward(request, response);
    }
}
