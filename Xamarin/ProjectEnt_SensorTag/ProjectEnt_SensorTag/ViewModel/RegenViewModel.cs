﻿using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.Network;
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

        private RelayCommand getInfo;

        private bool visible;

        public bool Visible
        {
            get { return visible; }
            set
            {
                visible = value;
                RaisePropertyChanged(() => Visible);
            }
        }

        public RelayCommand GetInfo
        {
            get { return getInfo; }
            set { getInfo = value; }
        }

        private INavigationService nav;

        private User user;

        public User User
        {
            get { return user; }
            set { user = value; }
        }

        private RelayCommand getTemp;

        public RelayCommand GetTemp
        {
            get { return getTemp; }
            set { getTemp = value; }
        }

        private RelayCommand getHumidity;

        public RelayCommand GetHumidity
        {
            get { return getHumidity; }
            set { getHumidity = value; }
        }


        public RegenViewModel(INavigationService nav)
        {
            this.nav = nav;
            Messenger.Default.Register<User>(this, (e) => User = e);

            if(nav != null)
            { 
            sensorTag = new SensorTag();
            }

            getInfo = new RelayCommand(() => 
            {
                 SendMessage.PostRequest<object, Humidity>("Somewhere",sensorTag.HumiditySensor.Humidity);
                 SendMessage.PostRequest<object, Temperature>("Somewhere", sensorTag.TemperatureSensor.Temperature);
                Visible = true;
            }, () => sensorTag.HumiditySensor.Humidity.HumidityAmount != 0 && sensorTag.TemperatureSensor.Temperature.TemperatureAmount != 0);
            getTemp = new RelayCommand(() =>
            {
                double temp = sensorTag.TemperatureSensor.Temperature.TemperatureAmount;
                while (temp == 0)
                { 
                    SensorTag.TemperatureSensor.GetTemperature();
                    temp = sensorTag.TemperatureSensor.Temperature.TemperatureAmount;
                }

                GetTemp.RaiseCanExecuteChanged();
                GetInfo.RaiseCanExecuteChanged();
            }, () => sensorTag.TemperatureSensor.Temperature.TemperatureAmount == 0);
            getHumidity = new RelayCommand(() =>
            {
                double humidity = sensorTag.HumiditySensor.Humidity.HumidityAmount;
                while (humidity <= 0.0 || humidity > 100.0)
                {
                    SensorTag.HumiditySensor.GetHumidity();
                    humidity = sensorTag.HumiditySensor.Humidity.HumidityAmount;
                }

                GetHumidity.RaiseCanExecuteChanged();
                GetInfo.RaiseCanExecuteChanged();
            },() => sensorTag.HumiditySensor.Humidity.HumidityAmount == 0);
        }
    }
}
