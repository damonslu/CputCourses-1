package za.ac.cput.cputcourses.services;

import java.util.List;

/**
 * Created by hashcode on 2015/09/01.
 */
public interface Services<S, ID> {

    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}