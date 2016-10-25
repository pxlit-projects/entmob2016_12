using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProjectEnt_SensorTag.UWP.ViewModels;
using ProjectEnt_SensorTag.UWP.Navigation;

namespace ProjectEnt_SensorTag.UWP
{
    class ViewModelLocator
    {
        private static LoginViewModel loginViewModel = new LoginViewModel(new NavigationService());

        public static LoginViewModel LoginViewModel
        {
            get
            {
                return loginViewModel;
            }
        }


        private static MainViewModel mainViewModel = new MainViewModel();

        public static MainViewModel MainViewModel
        {
            get
            {
                return mainViewModel;
            }
        }


        private static OverviewViewModel overviewViewModel = new OverviewViewModel();

        public static OverviewViewModel OverviewViewModel
        {
            get
            {
                return overviewViewModel;
            }
        }
    }
}
