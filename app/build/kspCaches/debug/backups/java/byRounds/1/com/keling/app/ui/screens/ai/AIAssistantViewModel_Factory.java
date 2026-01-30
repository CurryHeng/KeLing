package com.keling.app.ui.screens.ai;

import com.keling.app.data.repository.QwenRepository;
import com.keling.app.data.repository.TaskRepository;
import com.keling.app.data.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AIAssistantViewModel_Factory implements Factory<AIAssistantViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<QwenRepository> qwenRepositoryProvider;

  public AIAssistantViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider,
      Provider<QwenRepository> qwenRepositoryProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
    this.qwenRepositoryProvider = qwenRepositoryProvider;
  }

  @Override
  public AIAssistantViewModel get() {
    return newInstance(taskRepositoryProvider.get(), userRepositoryProvider.get(), qwenRepositoryProvider.get());
  }

  public static AIAssistantViewModel_Factory create(Provider<TaskRepository> taskRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider,
      Provider<QwenRepository> qwenRepositoryProvider) {
    return new AIAssistantViewModel_Factory(taskRepositoryProvider, userRepositoryProvider, qwenRepositoryProvider);
  }

  public static AIAssistantViewModel newInstance(TaskRepository taskRepository,
      UserRepository userRepository, QwenRepository qwenRepository) {
    return new AIAssistantViewModel(taskRepository, userRepository, qwenRepository);
  }
}
