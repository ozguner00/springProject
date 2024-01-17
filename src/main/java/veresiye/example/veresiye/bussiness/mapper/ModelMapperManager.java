package veresiye.example.veresiye.bussiness.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    @Override
    public ModelMapper forRespoense() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
