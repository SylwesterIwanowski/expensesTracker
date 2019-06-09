package org.sylwester.repository;

import org.sylwester.model.UserSettings;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<UserSettings, Integer> {

}
