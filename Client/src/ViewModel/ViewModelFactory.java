package ViewModel;

import Model.ModelClient;

public class ViewModelFactory
{
  private ShowRoomsViewModel showRoomsViewModel;
  private MainMenuViewModel mainMenuViewModel;
  private DetailsViewModel detailsViewModel;
  private LoginViewModel loginViewModel;
  private ManageAccViewModel manageAccViewModel;
  private ViewState viewState;


  public ViewModelFactory (ModelClient model)
  {
    this.viewState = new ViewState();
    this.showRoomsViewModel = new ShowRoomsViewModel(model,viewState);
    this.mainMenuViewModel = new MainMenuViewModel(model, viewState);
    this.detailsViewModel = new DetailsViewModel(model, viewState);
    this.loginViewModel = new LoginViewModel(model, viewState);
    this.manageAccViewModel = new ManageAccViewModel(model, viewState);
  }

  public ShowRoomsViewModel getShowRoomsViewModel()
  {
    return showRoomsViewModel;
  }
  public  MainMenuViewModel getMainMenuViewModel(){
    return mainMenuViewModel;
  }

  public DetailsViewModel getDetailsViewModel() {
    return detailsViewModel;
  }

  public LoginViewModel getLoginViewModel() {return loginViewModel;}
  public ManageAccViewModel getManageAccViewModel() {return manageAccViewModel;}
}
