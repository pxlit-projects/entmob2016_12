using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.SensorTagLib;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class RegenViewModel : ViewModelBase
    {
        private SensorTag sensorTag;

        public SensorTag SensorTag
        {
            get { return sensorTag; }
            set { sensorTag = value; }
        }

        private ICommand getInfo;

        public ICommand GetInfo
        {
            get { return getInfo; }
            set { getInfo = value; }
        }

        private INavigationService nav;
        
        public RegenViewModel(INavigationService nav)
        {
            this.nav = nav;
            
            sensorTag = new SensorTag();
            getInfo = new RelayCommand(() => sensorTag.Temperature.StartSensing());
        }
    }
}
