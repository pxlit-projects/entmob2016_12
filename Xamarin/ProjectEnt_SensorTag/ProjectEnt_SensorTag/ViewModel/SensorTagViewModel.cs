using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.SensorTagLib;
using ProjectEnt_SensorTag.SensorTagLib.Devices;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class SensorTagViewModel : ViewModelBase
    {
        private ObservableCollection<IDevice> deviceList;
        public ObservableCollection<IDevice> DeviceList
        {
            get { return deviceList; }
            set
            {
                deviceList = value;
                RaisePropertyChanged("DeviceList");
            }
        }

        private INavigationService nav;
        public INavigationService Nav
        {
            get { return nav; }
            set { nav = value; }
        }

        private IDevice device;
        public IDevice Device
        {
            get
            {
                return device;
            }
            set
            {
                if (device != value)
                {

                    DeviceSetup.StopScanning();
                    Set(() => Device, ref device, value);
                  
                    nav.NavigateTo("SensorTagDetail");
                    Messenger.Default.Send<IDevice>(device);
                    device = null;
                }
            }
        }
       
        public SensorTagViewModel(INavigationService nav)
        {
            this.nav = nav;
            refreshList = new RelayCommand(() =>
            {
                DeviceList = new ObservableCollection<IDevice>();
                GetDeviceList();
            }, () => Scanning);
        }
        public async void GetDeviceList()
        {
            try
            {
                var device = await DeviceSetup.FindDevice((e) =>
                {
                    Scanning = e;
                });

                deviceList.Add(device);
            }
            catch
            {

            }
        }
        private Boolean scanning = true;

        public Boolean Scanning
        {
            get { return scanning; }
            set
            {
                scanning = value;
                refreshList.RaiseCanExecuteChanged();
            }
        }


        private RelayCommand refreshList;
        public RelayCommand RefreshList
        {
            get { return refreshList; }
            set { refreshList = value; }
        }
    }
}