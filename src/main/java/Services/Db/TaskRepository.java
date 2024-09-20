package Services.Db;

import Entities.Task;
import Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUsuario(Usuario usuario);
}
