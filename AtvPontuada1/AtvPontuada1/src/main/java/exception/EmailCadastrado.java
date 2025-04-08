package exception;

public class EmailCadastrado extends RuntimeException{
        public EmailCadastrado(String message) {
            super(message);
        }
    }
