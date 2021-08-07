package kg.megacom.salonmaster.services;

import java.util.List;

public interface BaseService <S,T>{
    S save( S s);

    S update( S s);

    List<S> findAll();

    S findById( T id);
}
