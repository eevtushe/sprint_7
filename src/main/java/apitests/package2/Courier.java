package apitests.package2;
import com.google.gson.Gson;

    public class Courier {

        private String login;
        private String password;
        private String firstName;
        private String id;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
