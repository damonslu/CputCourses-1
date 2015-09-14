package za.ac.cput.cputcourses.respositories;

import java.util.List;

/**
 * Created by hashcode on 2015/09/01.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
