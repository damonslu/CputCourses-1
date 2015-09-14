package za.ac.cput.cputcourses.services.Impl;

import java.util.List;

import za.ac.cput.cputcourses.model.Subject;
import za.ac.cput.cputcourses.respositories.RestAPI;
import za.ac.cput.cputcourses.respositories.rest.RestSubjectAPI;
import za.ac.cput.cputcourses.services.SubjectService;

/**
 * Created by hashcode on 2015/09/01.
 */
public class SubjectServiceImpl  implements SubjectService{
    final RestAPI<Subject,Long> rest = new RestSubjectAPI();
    @Override
    public Subject findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Subject entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Subject entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Subject entity) {
        return rest.delete(entity);

    }

    @Override
    public List<Subject> findAll() {
        return rest.getAll();
    }
}
