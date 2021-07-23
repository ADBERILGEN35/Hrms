package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Language;
import kodlamaio.Hrms.entities.dtos.LanguageForSetDto;

import java.util.List;

public interface LanguageService {
    public Result addLanguage(LanguageForSetDto languageForSetDto);

    public Result deleteLanguage(int languageId);

    public DataResult<List<Language>> getByCvId(int cvId);
}
