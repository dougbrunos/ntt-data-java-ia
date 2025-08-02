package set;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

class User {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // A implementação do método toString na classe User formata a saída de forma legível, facilitando a depuração e o registro de informações.
    @Override
    public String toString() {
        return String.format("{'id': %d, 'name': '%s'}", id, name);
    }

    // O método equals é usado para comparar dois objetos User, verificando se ambos têm o mesmo id e nome.
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if ((isNull(obj)) || (!(obj instanceof User))) return false;
        var user = (User) obj;
        return this.id == user.id && this.name.equals(user.name);
    }

    // O método hashCode é usado para gerar um código hash único para cada objeto User, baseado no id e nome, o que é importante para a eficiência em coleções como HashSet.
    @Override
    public int hashCode() {
        return hash(this.id, this.name);
    }

}
