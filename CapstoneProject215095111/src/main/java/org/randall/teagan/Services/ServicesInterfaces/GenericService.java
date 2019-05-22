package org.randall.teagan.Services.ServicesInterfaces;

public interface GenericService<T, ID> {

        T create(T type);
        T update(T type);
        void delete(ID id);
        T read(ID id);
}

