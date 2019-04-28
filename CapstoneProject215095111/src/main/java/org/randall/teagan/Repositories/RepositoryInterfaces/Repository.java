package org.randall.teagan.Repositories.RepositoryInterfaces;

public interface Repository<T, ID> {

    T create(T t);
    T update(T t);
    void delete(String id);
    T read(String id);

}
