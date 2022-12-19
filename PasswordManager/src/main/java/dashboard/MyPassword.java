package dashboard;

public class MyPassword {
    private int id;
    private String nome;
    private String nomeUtente;
    private String password;
    private String Url;


    public MyPassword(int id, String nome, String nomeUtente, String password, String url) {
        this.id = id;
        this.nome = nome;
        this.nomeUtente = nomeUtente;
        this.password = password;
        Url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "MyPassword{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeUtente='" + nomeUtente + '\'' +
                ", password='" + password + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}

