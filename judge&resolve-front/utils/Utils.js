import React, {useState, useEffect} from 'react';

const someCommonValues = ['common', 'values'];

export const DaysOfWeek = {
    MONDAY: 0,
    TUESDAY: 1,
    WEDNESDAY: 2,
    THURSDAY: 3,
    FRIDAY: 4,
    SATURDAY: 5,
    SUNDAY: 6
  };

export const setDay = (date, dayOfWeek) => {
    date = new Date(date.getTime());
    date.setDate(date.getDate() + (dayOfWeek + 7 - date.getDay()) % 7);
    return date;
};

const showError = err => {
  // your custom error display logic
  alert(err);
};

export const useFetch = ({ url, initialState = null, skip = false }) => {
  const [data, setData] = useState(initialState);
  const [isLoading, setIsLoading] = useState(true);
  const [reload, setReload] = useState({}); // used to force running the api fetch in effect

  useEffect(() => {
    let mounted = true;

    if (!skip) {
      setIsLoading(true);

      fetch(url)
        .then(res => res.json())
        .then(result => {
          mounted && setData(result);
        })
        .catch(showError)
        .finally(() => {
          mounted && setIsLoading(false);
        });
    }

    return () => {
      mounted = false;
    };
  }, [url, reload, skip]);

  const reloadData = () => {
    setReload({});
  };

  return { data, setData, isLoading, reloadData };
};
