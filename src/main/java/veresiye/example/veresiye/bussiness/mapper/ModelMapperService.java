package veresiye.example.veresiye.bussiness.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forRespoense();
}
