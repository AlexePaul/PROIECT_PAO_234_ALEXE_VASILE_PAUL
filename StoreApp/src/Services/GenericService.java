package Services;

import java.util.List;
@SuppressWarnings("unused")
public interface GenericService<Type> {
    List<Type> GetAll();
}
